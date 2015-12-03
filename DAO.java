package com.ittralee.ie.workflow;

import java.sql.SQLException;

/**
 * Created by Roisin O'Connor on 22/11/2015.
 */
public interface DAO {


User find(User user) throws SQLException;


}
