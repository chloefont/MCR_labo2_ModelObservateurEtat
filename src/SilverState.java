public class SilverState extends AccountState {
    /**
     * Create an account for a client
     *
     * @param owner Client who wons this account
     */
    public SilverState(Client owner) {
        super(owner);
    }

    @Override
    protected void stateChangeCheck() {

    }

    @Override
    public void bookMiles(double price) {

    }

    @Override
    public void bookCash(double price) {

    }

    @Override
    public void deposit(double amount) {

    }
}
