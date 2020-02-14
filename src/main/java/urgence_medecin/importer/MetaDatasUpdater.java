package urgence_medecin.importer;

import java.util.List;

/**
 * This class generates the SQL statements for updating a list of Post Ids
 * (referenced to POST object in Wordpress) of the table {@code wpp9_postmeta}.
 * 
 * <pre>
 * 
insert into wpp9_postmeta values(	391350	,6454	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391351	,6455	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391352	,6456	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391353	,6457	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391354	,6459	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391355	,6460	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391356	,6461	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391357	,6462	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391358	,6463	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391359	,6464	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391360	,6465	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391361	,6521	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
 * 
 * </pre>
 * 
 * with :
 * <ul>
 * <li>first value is the new meta ID to be inserted (incremented manually
 * here)</li>
 * <li>second value is the post ids (in the example are the ids of the
 * departements)</li>
 * <li>third value is the meta key of the POD to be updated</li>
 * <li>forth value is the meta value of the POD to be updated</li>
 * 
 * @author khoa
 *
 */
public class MetaDatasUpdater {

	/**
	 * List of POST objects to be updated
	 */
	private final List<Long> postIds;
	/**
	 * The first meta ID to be incremented
	 */
	private final Long firstMetaId;
	/**
	 * The variable meta key
	 */
	private final String metaKey;
	/**
	 * The list of all possible values for the variable metakey
	 * {@link MetaDatasUpdater#metaKey}
	 */
	private final List<String> metaValues;

	public MetaDatasUpdater(List<Long> postIds, Long firstMetaId, String metaKey, List<String> metaValues) {
		this.postIds = postIds;
		this.firstMetaId = firstMetaId;
		this.metaKey = metaKey;
		this.metaValues = metaValues;
	}

	public String generateStatements() {

		return null;
	}

	public List<Long> getPostIds() {
		return postIds;
	}

	public Long getFirstMetaId() {
		return firstMetaId;
	}

	public String getMetaKey() {
		return metaKey;
	}

	public List<String> getMetaValues() {
		return metaValues;
	}

}
