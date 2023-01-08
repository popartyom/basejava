package com.urise.webapp.model;

import java.util.*;

/**
 * @author Artyom Popov
 */
public class OrganisationSection extends Section {
    private final List<Organisation> organisations;

    public OrganisationSection(List<Organisation> organisations) {
        Objects.requireNonNull(organisations, "organisations must not be null");
        this.organisations = organisations;
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    @Override
    public String toString() {
        return organisations.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganisationSection that = (OrganisationSection) o;

        return organisations.equals(that.organisations);
    }

    @Override
    public int hashCode() {
        return organisations.hashCode();
    }
}
