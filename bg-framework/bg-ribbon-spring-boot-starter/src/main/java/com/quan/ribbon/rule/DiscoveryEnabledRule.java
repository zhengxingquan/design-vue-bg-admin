package com.quan.ribbon.rule;

import com.netflix.loadbalancer.*;
import com.quan.ribbon.predicate.DiscoveryEnabledPredicate;
import org.springframework.util.Assert;

/**
 * A simple {@link IRule} for matching the discovered server instances. The actual matching is being performed by the
 * registered instance of {@link DiscoveryEnabledPredicate} allowing to adjust the actual matching strategy.
 *
 * @author Jakub Narloch
 * @see DiscoveryEnabledPredicate
 */
public abstract class DiscoveryEnabledRule extends PredicateBasedRule {

    private final CompositePredicate predicate;

    /**
     * Creates new instance of {@link DiscoveryEnabledRule} class with specific predicate.
     *
     * @param discoveryEnabledPredicate the discovery enabled predicate, can't be null
     * @throws IllegalArgumentException if {@code discoveryEnabledPredicate} is {@code null}
     */
    public DiscoveryEnabledRule(DiscoveryEnabledPredicate discoveryEnabledPredicate) {
        Assert.notNull(discoveryEnabledPredicate, "Parameter 'discoveryEnabledPredicate' can't be null");
        this.predicate = createCompositePredicate(discoveryEnabledPredicate, new AvailabilityPredicate(this, null));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractServerPredicate getPredicate() {
        return predicate;
    }

    /**
     * Creates the composite predicate with fallback strategies.
     *
     * @param discoveryEnabledPredicate the discovery service predicate
     * @param availabilityPredicate     the availability predicate
     * @return the composite predicate
     */
    private CompositePredicate createCompositePredicate(DiscoveryEnabledPredicate discoveryEnabledPredicate, AvailabilityPredicate availabilityPredicate) {
        return CompositePredicate.withPredicates(discoveryEnabledPredicate, availabilityPredicate)
                .build();
    }
}
