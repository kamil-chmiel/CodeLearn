package com.company.codelearn.database;

public class DatabaseConsts {
    public class Ranking {
        public static final String TABLE_NAME = "ranking";
        public static final String ID = "id";
        public static final String POINTS = "points";
        public static final String UNLOCKED_LECTURES = "unlocked_lectures";

        public class Queries {
            public static final String GET_RANKING_LIST_QUERY = "SELECT * FROM users NATURAL JOIN ranking ORDER BY points DESC";
        }
    }

    public class Users {
        public static final String TABLE_NAME = "users";
        public static final String ID = "id";
        public static final String EMAIL = "email";
        public static final String NAME = "name";
    }
}