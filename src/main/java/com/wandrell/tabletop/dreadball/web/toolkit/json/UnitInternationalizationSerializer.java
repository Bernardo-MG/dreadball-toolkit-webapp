
package com.wandrell.tabletop.dreadball.web.toolkit.json;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

public final class UnitInternationalizationSerializer
        extends BeanSerializerBase {

    private static final long   serialVersionUID = -4564768381234004926L;

    private final MessageSource messageSource;

    public UnitInternationalizationSerializer(final BeanSerializerBase source,
            final MessageSource ms) {
        super(source);

        messageSource = checkNotNull(ms,
                "Received a null pointer as message source");
    }

    @Override
    public final void serialize(final Object value, final JsonGenerator gen,
            final SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        serializeFields(value, gen, provider);
        if (value instanceof Unit) {
            gen.writeStringField("role_i18n",
                    getMessageSource().getMessage(
                            ((Unit) value).getRole().toString().toLowerCase(),
                            null, LocaleContextHolder.getLocale()));
        }
        gen.writeEndObject();
    }

    @Override
    public final BeanSerializerBase withFilterId(final Object filterId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final BeanSerializerBase
            withObjectIdWriter(final ObjectIdWriter objectIdWriter) {
        // TODO Auto-generated method stub
        return null;
    }

    private final MessageSource getMessageSource() {
        return messageSource;
    }

    @Override
    protected final BeanSerializerBase asArraySerializer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected final BeanSerializerBase
            withIgnorals(final Set<String> toIgnore) {
        // TODO Auto-generated method stub
        return null;
    }

}
