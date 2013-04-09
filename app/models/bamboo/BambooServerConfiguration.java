package models.bamboo;

import models.BasicServerConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: jpereira
 * Date: 4/8/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class BambooServerConfiguration extends BasicServerConfiguration {

    public static class Builder extends BasicServerConfiguration.Builder<BambooServerConfiguration> {

        BambooServerConfiguration configObject = new BambooServerConfiguration();

        @Override
        protected BasicServerConfiguration getConfigObject() {
            return configObject;
        }

        @Override
        public BambooServerConfiguration build() {
            return configObject;
        }
    }
}
