package me.mcblueparrot.spade.config;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;

public class YamlConfigurationSystem implements ConfigurationSystem {

	private Yaml yaml;

	public YamlConfigurationSystem() {
		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(FlowStyle.BLOCK);
		yaml = new Yaml(options);
	}

	@Override
	public Configuration load(String data) {
		return new Configuration(yaml.load(data));
	}

	@Override
	public String save(Configuration configuration) {
		return yaml.dump(configuration.getMap());
	}

	@Override
	public String getExtension() {
		return "yaml";
	}

}
