public class Arguments {
    private String host;
    private String user;
    private String password;
    private String database;

    public Arguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-h") && (i < args.length - 1)) {
                i++;
                host = args[i];
            } else if (args[i].equals("-u") && i < args.length - 1) {
                i++;
                user = args[i];
            } else if (args[i].equals("-p") && i < args.length - 1) {
                i++;
                password = args[i];
            } else if (args[i].equals("-d") && i < args.length - 1) {
                i++;
                database = args[i];
            }
        }
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }
}