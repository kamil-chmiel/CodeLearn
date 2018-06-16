package com.company.codelearn.database;

public class DatabaseConsts {
    public class Ranking {
        public static final String TABLE_NAME = "ranking";
        public static final String ID = "id";
        public static final String POINTS = "points";
        public class RawQueries {
            public static final String GET_RANKING_LIST_QUERY = "SELECT * FROM users NATURAL JOIN ranking ORDER BY points DESC";
        }
    }

    public class Users {
        public static final String TABLE_NAME = "users";
        public static final String ID = "id";
        public static final String EMAIL = "email";
        public static final String NAME = "name";
    }

    public class FriendList {
        public static final String TABLE_NAME = "friend_list";
        public static final String ID = "id";
        public static final String FRIEND_ID = "friend_id";
        public class RawQueries {
            public static final String GET_FRIEND_LIST = "SELECT * FROM friend_list LEFT JOIN users ON friend_list.friend_id = users.id WHERE friend_list.id = ?;";
        }
    }
}