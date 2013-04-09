package models.bamboo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/8/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class BambooBuildBuilder {

    private List<String> bambooBuildKeys;
    private BambooServer bambooServer;

    public BambooBuildBuilder withPlanKey(String[] bambooBuildKeys) {
        this.bambooBuildKeys = Arrays.asList(bambooBuildKeys);
        return this;

    }

    public BambooBuildBuilder with(BambooServer bambooServer) {
        this.bambooServer = bambooServer;
        return this;
    }

    public List<BambooBuild> build() throws BambooBuildException {
        if (bambooServer == null || this.bambooBuildKeys == null) {
            throw new BambooBuildException("A bamboo server and bamboo plan keys are required");
        }

        BambooBuildAssembler assembler = new BambooBuildAssembler(bambooServer);

        List<BambooBuild> builds = new ArrayList<>();

        for (String bambooPlanKey : this.bambooBuildKeys) {
            builds.add(assembler.assemble(bambooPlanKey));
        }

        return builds;
    }
}
