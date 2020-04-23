# Liferay GSearch - Modificações GS Latam


## Módulos:

### gsearch-core-impl

####	 Arquivos

**build.gradle**

Adicionado a linha 	<code>compileOnly fileTree(dir:'src/main/resources/libs',include:['*.jar'])</code> para dependência ao módulo pbrintra-structure-facet


**GSearchImpl.java**

Adicionado referência ao serviço StructureFacetFilterUtil, para ter acesso as configurações de sistemas para aplicação de um filtro por structureKeys específicos configurados através das System Settings.

**BaseResultItemBuilder.java**

Modificação do campo CONTENT para DESCRIPTION, esse campo é usado na caixa de sugestão do campo de busca da página, antes era usado o campo CONTENT como descrição, modificamos para o DESCRIPTION.

**StructureFacetFilterUtil.java**

Nova classe criada para ter acesso as configurações através do StructureFacetConfiguration API

### gsearch-mini-web

#### Arquivos

**Language_pt_BR.properties**

Novo language properties para tradução das language keys para portugês Brasil

**mains.css**

Modificações de Layout na caixa de sugestão de conteúdo que é exibida entre outras.

### Pull Request com as modificaçõe

<https://github.com/liferay-gs-latam/liferay-gsearch/pull/1>