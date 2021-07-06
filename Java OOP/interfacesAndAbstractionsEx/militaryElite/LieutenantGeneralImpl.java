package interfacesAndAbstractionsEx.militaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<PrivateImpl> priv;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.priv = new ArrayList<>();
    }


    private List<PrivateImpl> getPriv() {
        return this.priv;
    }

    @Override
    public void addPrivate(PrivateImpl priv) {
        this.getPriv().add(priv);
    }

    @Override
    public String toString() {
        priv = priv.stream()
                .sorted((x,y) -> y.getId() - x.getId())
                .collect(Collectors.toList());
        StringBuilder output = new StringBuilder();
        output.append(super.toString()).append(System.lineSeparator())
                .append("Privates:").append(System.lineSeparator());
        priv.forEach(p -> output.append(p.toString()).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
