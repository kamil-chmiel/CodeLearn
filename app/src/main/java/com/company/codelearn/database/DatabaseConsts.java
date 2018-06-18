package com.company.codelearn.database;

public class DatabaseConsts {
    public class Ranking {
        public static final String TABLE_NAME = "ranking";
        public static final String ID = "id";
        public static final String POINTS = "points";
        public class RawQueries {
            public static final String GET_RANKING_LIST_QUERY = "SELECT * FROM users NATURAL JOIN ranking ORDER BY points DESC";
            public static final String GET_USER_POINTS = "SELECT points FROM ranking WHERE id = ?;";
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

    public class Lectures {
        public static final String TABLE_NAME = "lectures";
        public static final String ID = "id";
        public static final String FILENAME = "filename";
    }

    public class Quizzes {
        public static final String TABLE_NAME = "quizzes";
        public static final String ID = "id";
        public static final String FILENAME = "filename";
    }

    public class UserLectures {
        public static final String TABLE_NAME = "user_lectures";
        public static final String ID = "user_id";
        public static final String LASTLECTUREID = "last_lecture_id";
        public class RawQueries {
            public static final String GET_USER_LAST_LECTURE_ID = "SELECT last_lecture_id FROM user_lectures WHERE user_id = ?;";
        }
    }

    public class UserQuizzes {
        public static final String TABLE_NAME = "user_quizzes";
        public static final String UNIQUEID = "unique_id";
        public static final String ID = "user_id";
        public static final String QUIZID = "quiz_id";
        public static final String SCORE = "score";
        public class RawQueries {
            public static final String GET_USER_QUIZ_ID_SCORE = "SELECT score FROM user_quizzes WHERE user_id = ? AND quiz_id = ?;";
        }
    }


}