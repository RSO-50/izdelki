package si.rsvo.izdelki.models.converters;

import si.rsvo.izdelki.lib.UporabnikoviIzdelkiMetadata;
import si.rsvo.izdelki.models.entities.izdelkiMetadataEntity;

public class izdelkiMetadataConverter {

    public static izdelkiMetadata toDto(izdelkiMetadataEntity entity) {

        izdelkiMetadata dto = new izdelkiMetadata();
        dto.setCenaId(entity.getCenaId());
        dto.setIzdelekId(entity.getIzdelekId());

        return dto;

    }

    public static izdelkiMetadataEntity toEntity(izdelkiMetadata dto) {

        izdelkiMetadataEntity entity = new izdelkiMetadataEntity();
        entity.setCenaId(dto.getCenaId());
        entity.setIzdelekId(dto.getIzdelekId());

        return entity;

    }

}
