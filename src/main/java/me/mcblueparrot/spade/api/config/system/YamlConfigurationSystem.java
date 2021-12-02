package me.mcblueparrot.spade.api.config.system;

import java.io.Reader;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;

import me.mcblueparrot.spade.api.config.Configuration;

/**
 * Represents a configuration system for YAML.
 */
public class YamlConfigurationSystem extends ConfigurationSystem {

	private ThreadLocal<Yaml> yaml;

	/**
	 * Creates a YAML configuration system with default settings.
	 */
	public YamlConfigurationSystem() {
		super("yaml");
		yaml = new ThreadLocal<Yaml>() {

			@Override
			protected Yaml initialValue() {
				DumperOptions options = new DumperOptions();
				options.setDefaultFlowStyle(FlowStyle.BLOCK);
				return new Yaml(options);
			}

		};
	}

	/**
	 * Creates a YAML configuration system.
	 * <p>Example usage:</p>
	 * <pre><code>YamlConfigurationSystem system = new YamlConfigurationSystem(
	 *    new ThreadLocal&lt;Yaml&gt;() {
	 *
	 *        &#64;Override
	 *        protected Yaml initialValue() {
	 *            return new Yaml();
	 *        }
	 *
	 *    }
	 *);</code></pre>
	 * @param yaml the {@link ThreadLocal} that provides a {@link Yaml} object
	 */
	public YamlConfigurationSystem(ThreadLocal<Yaml> yaml) {
		super("yaml");
		this.yaml = yaml;
	}

	@Override
	public Configuration load(Reader reader) {
		return new Configuration(yaml.get().load(reader));
	}

	@Override
	public String save(Configuration config) {
		return yaml.get().dump(config.getMap());
	}

}
