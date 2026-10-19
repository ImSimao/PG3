package i2627.trab1.grupo3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public final class VehicleRentalManager {

    final List<RentalVehicle> availableVehicles = new ArrayList<>();
    final List<RentalVehicle> rentedVehicles = new ArrayList<>();

    public void addAvailableVehicles(RentalVehicle... vehicles) throws VehicleException {   // Se o veiculo não existir nas listas adiciona, evita entradas duplicadas do mesmo veiculo
        for (RentalVehicle vehicle : vehicles) {
            if (availableVehicles.contains(vehicle) || rentedVehicles.contains(vehicle)) {
                throw new VehicleException("Vehicle is already in system", vehicle);
            }
            availableVehicles.add(vehicle);
        }
    }

    public void rentVehicle(RentalVehicle vehicle) throws VehicleException {
        if (!availableVehicles.remove(vehicle)) {   // Tenta remover o veiculo da lista dos disponiveis, se conseguir (remove==true) adiciona-o aos arrendados, se não remover então throw exception
            throw new VehicleException("Vehicle is not available for rent", vehicle);
        }
        rentedVehicles.add(vehicle);
    }

    public double returnVehicle(RentalVehicle vehicle, long km) throws VehicleException {
        if (!rentedVehicles.remove(vehicle)) {
            throw new VehicleException("Vehicle was not rented", vehicle);
        }
        availableVehicles.add(vehicle);
        vehicle.addKilometers(km);
        return vehicle.calculateRent(km);
    }

    public void deleteVehicle(RentalVehicle vehicle) throws VehicleException {
        if (!availableVehicles.remove(vehicle) && !rentedVehicles.remove(vehicle)) {
            throw new VehicleException("Vehicle not found in the system", vehicle);
        }
    }

    public static List<RentalVehicle> getVehicles(List<RentalVehicle> vehicles,
                                                  Predicate<RentalVehicle> filter) {
        List<RentalVehicle> result = new ArrayList<>();
        for (RentalVehicle vehicle : vehicles) {
            if (filter.test(vehicle)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public RentalVehicle[] getVehiclesAboveKm(long km) {
        Predicate<RentalVehicle> above = vehicle -> vehicle.getKilometers() > km;
        List<RentalVehicle> result = new ArrayList<>();
        result.addAll(getVehicles(availableVehicles, above));
        result.addAll(getVehicles(rentedVehicles, above));
        result.sort(Comparator.naturalOrder());
        return result.toArray(RentalVehicle[]::new);
    }

    public RentalVehicle[] getVansAboveLoad(int load) {
        Predicate<RentalVehicle> above = vehicle -> maxLoadOf(vehicle) > load;
        List<RentalVehicle> result = getVehicles(availableVehicles, above);
        result.sort(Comparator.comparingInt(VehicleRentalManager::maxLoadOf));
        return result.toArray(RentalVehicle[]::new);
    }

    private static int maxLoadOf(RentalVehicle vehicle) {
        if (vehicle instanceof CommercialVan van) {
            return van.getMaxLoad();
        }
        if (vehicle instanceof SubLeased sub && sub.vehicle instanceof CommercialVan van) {
            return van.getMaxLoad();
        }
        return -1;
    }
}