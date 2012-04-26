package pt.ist.data;

public class MergeRequest {

    private DataObjectVersion fromDataObjectVersion;
    private DataObject toDataObject;

    public MergeRequest(DataObjectVersion fromDataObjectVersion, DataObject toDataObject) {
        this.fromDataObjectVersion = fromDataObjectVersion;
        this.toDataObject = toDataObject;
    }

    public DataObjectVersion getFromDataObjectVersion() {
        return fromDataObjectVersion;
    }

    public DataObject getToDataObject() {
        return toDataObject;
    }
}
