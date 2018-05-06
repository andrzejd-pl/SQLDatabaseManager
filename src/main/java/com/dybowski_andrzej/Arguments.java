package com.dybowski_andrzej;

public class Arguments {
    private String host;
    private String user;
    private String password;
    private String database;
    private String query;
    private String file;
    private boolean help;

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
            } else if (args[i].equals("-q") && i < args.length - 1) {
                i++;
                query = args[i];
            } else if (args[i].equals("-f") && i < args.length - 1) {
                i++;
                file = args[i];
            } else if (args[i].equals("--help")) {
                help = true;
            }
        }
    }

    public boolean getArgumentsFromConsole() {
        //todo: napisać tą funkcję!!!
        return true;
    }

    public boolean isEmpty() {
        return !(isHost() && isUser() && isPassword() && isDatabase());
    }

    public boolean isHost() {
        return (host != null);
    }

    public boolean isUser() {
        return (user != null);
    }

    public boolean isPassword() {
        return (password != null);
    }

    public boolean isDatabase() {
        return (database != null);
    }

    public boolean isQuery() {
        return (query != null);
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

    public String getQuery() {
        return query;
    }
}