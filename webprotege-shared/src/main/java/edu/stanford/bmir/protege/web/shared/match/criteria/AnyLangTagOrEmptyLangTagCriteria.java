package edu.stanford.bmir.protege.web.shared.match.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.GwtCompatible;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 16 Jun 2018
 */
@AutoValue
@GwtCompatible(serializable = true)
@JsonTypeName("AnyLangTag")
public class AnyLangTagOrEmptyLangTagCriteria implements LangTagCriteria {

    @JsonCreator
    @Nonnull
    public static AnyLangTagOrEmptyLangTagCriteria get() {
        return new AutoValue_AnyLangTagOrEmptyLangTagCriteria();
    }

    @Override
    public <R> R accept(@Nonnull AnnotationValueCriteriaVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <R> R accept(@Nonnull LiteralCriteriaVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
