package pt.ist.organization;

public class Person extends Person_Base {

    public void init(String name) {
        setName(name);
    }

    @Override
    public boolean isPerson() {
        return true;
    }

    @Override
    public boolean isOrganizationalUnit() {
        return false;
    }
}
