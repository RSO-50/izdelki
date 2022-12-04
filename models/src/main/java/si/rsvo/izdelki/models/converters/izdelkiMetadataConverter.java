package si.rsvo.izdelki.models.converters;

import si.rsvo.izdelki.lib.UporabnikoviIzdelkiMetadata;
import si.rsvo.izdelki.models.entities.izdelkiMetadataEntity;

public class izdelkiMetadataConverter {

    public static izdelkiMetadata toDto(izdelkiMetadataEntity entity) {

        izdelkiMetadata dto = new izdelkiMetadata();
        dto.setizdelek(entity.getizdelek());
        dto.setIzdelekId(entity.getIzdelekId());

        return dto;

    }

    public static izdelkiMetadataEntity toEntity(izdelkiMetadata dto) {

        izdelkiMetadataEntity entity = new izdelkiMetadataEntity();
        entity.setizdelek(dto.getizdelek());
        entity.setIzdelekId(dto.getIzdelekId());

        return entity;

    }

}
