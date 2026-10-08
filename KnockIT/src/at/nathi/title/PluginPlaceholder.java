package at.nathi.title;

import com.gmail.filoghost.holographicdisplays.api.placeholder.PlaceholderReplacer;

public class PluginPlaceholder implements PlaceholderReplacer{

	private final int plugins;
	
	public PluginPlaceholder(int plugins) {
		this.plugins = plugins;
	}
	@Override
	public String update() {

		return String.valueOf(plugins);
	}
	
	

}
