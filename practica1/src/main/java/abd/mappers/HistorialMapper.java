package abd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import abd.AbstractMapper;
import abd.mappers.keys.HistorialKey;
import abd.model.Historial;

public class HistorialMapper extends AbstractMapper<Historial, HistorialKey> {

	public HistorialMapper(DataSource ds) {
		super(ds);
	}

	@Override
	protected String getTableName() {
		return "Historial";
	}

	@Override
	protected String[] getColumnNames() {
		return new String[]{"crucigrama","usuario","propietario",
				"respuesta","fecha","hora","correcta","puntuacion"};
	}

	@Override
	protected String[] getKeyColumnNames() {
		return new String[]{"crucigrama","usuario"};
	}

	@Override
	protected Historial buildObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] decomposeKey(HistorialKey key) {
		// TODO Auto-generated method stub
		return null;
	}

}
