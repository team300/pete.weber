package websample;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetBeanMapping<T> {

	/**
	 * ResultSet�����ɃI�u�W�F�N�g���쐬����
	 */
    public T createFromResultSet(ResultSet rs)
            throws SQLException;

}
