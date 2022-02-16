package businesscomponent.idgenerator;

import java.io.IOException;

import architecture.dao.DAOException;

public interface IdGeneratorInterface {
	long getNextId() throws DAOException, ClassNotFoundException, IOException;

}
