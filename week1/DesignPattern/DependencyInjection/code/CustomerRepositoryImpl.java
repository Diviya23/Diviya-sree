public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Simulated data fetch
        return new Customer(id, "John Doe");
    }
}
