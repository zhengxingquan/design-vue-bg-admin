package com.quan.ribbon.rule;


import com.quan.ribbon.predicate.DiscoveryEnabledPredicate;
import com.quan.ribbon.predicate.MetadataAwarePredicate;

/**
 * A metadata aware {@link DiscoveryEnabledRule} implementation.
 *
 * @author Jakub Narloch
 * @see DiscoveryEnabledRule
 * @see MetadataAwarePredicate
 */
public class MetadataAwareRule extends DiscoveryEnabledRule {

    /**
     * Creates new instance of {@link MetadataAwareRule}.
     */
    public MetadataAwareRule() {
        this(new MetadataAwarePredicate());
    }

    /**
     * Creates new instance of {@link MetadataAwareRule} with specific predicate.
     *
     * @param predicate the predicate, can't be {@code null}
     * @throws IllegalArgumentException if predicate is {@code null}
     */
    public MetadataAwareRule(DiscoveryEnabledPredicate predicate) {
        super(predicate);
    }
}
