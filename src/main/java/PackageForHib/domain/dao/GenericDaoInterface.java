package PackageForHib.domain.dao;

public interface GenericDaoInterface<T,ID> {

    T findById(ID  id);
}
