
package com.wandrell.tabletop.dreadball.web.toolkit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public final class ProjectInfoInitializer {

    @Value("${project.version}")
    private String projectVersion;

    @Value("${project.year}")
    private String projectYear;

    @Value("${project.author.name}")
    private String authorName;

    @Value("${project.author.url}")
    private String authorUrl;

    @Value("${project.license.name}")
    private String licenseName;

    @Value("${project.license.url}")
    private String licenseUrl;

    @Value("${project.scm.url}")
    private String scmUrl;

    @Value("${project.description}")
    private String projectDescription;

    @Value("${project.keywords}")
    private String projectKeywords;

    public ProjectInfoInitializer() {
        super();
    }

    @ModelAttribute("projectLicense")
    public final String getLicense() {
        return licenseName;
    }

    @ModelAttribute("projectLicenseUrl")
    public final String getLicenseUrl() {
        return licenseUrl;
    }

    @ModelAttribute("projectAuthor")
    public final String getProjectAuthor() {
        return authorName;
    }

    @ModelAttribute("projectAuthorUrl")
    public final String getProjectAuthorUrl() {
        return authorUrl;
    }

    @ModelAttribute("projectDescription")
    public final String getProjectDescription() {
        return projectDescription;
    }

    @ModelAttribute("projectKeywords")
    public final String getProjectKeywords() {
        return projectKeywords;
    }

    @ModelAttribute("projectVersion")
    public final String getProjectVersion() {
        return projectVersion;
    }

    @ModelAttribute("projectYear")
    public final String getProjectYear() {
        return projectYear;
    }

    @ModelAttribute("projectGithubUrl")
    public final String getScmUrl() {
        return scmUrl;
    }

}
