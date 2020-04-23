package fi.soveltia.liferay.gsearch.core.impl.util;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;

import br.com.petrobras.portlet.structure.facet.configuration.StructureFacetConfiguration;

/**
 * Structure Facte Util to get filter by structureddmkey from configuration
 * 
 * @author Anderson Perrelli
 */
@Component(
	configurationPid = "br.com.petrobras.portlet.structure.configuration.StructureFacetConfiguration",
	immediate = true, 
	service = StructureFacetFilterUtil.class
)
public class StructureFacetFilterUtil {
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {

		_structureFacetConfiguration = ConfigurableUtil.createConfigurable(
				StructureFacetConfiguration.class, properties);

	}
	
	public TermsFilter getTermsFilterFromConfigurationField() {
		
		TermsFilter termsFilter = new TermsFilter(_structureFacetConfiguration.termFilterField());
		termsFilter.addValues(ArrayUtil.toStringArray(_structureFacetConfiguration.structureKeys()));
		
		return termsFilter;
	}
	
	private volatile StructureFacetConfiguration _structureFacetConfiguration;
}