class AuthService {
    public User login(String name, String role){
        // check database;
        return new User(1,name, role);
    }

    public void signup(User user) {
        //store user
    }
}