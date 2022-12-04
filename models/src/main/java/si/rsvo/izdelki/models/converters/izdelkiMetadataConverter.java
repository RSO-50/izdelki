package si.rsvo.izdelki.models.converters;

import si.rsvo.izdelki.lib.izdelkiMetadata;
import si.rsvo.izdelki.models.entities.izdelkiMetadataEntity;

public class izdelkiMetadataConverter {

    public static izdelkiMetadata toDto(izdelkiMetadataEntity entity) {

        izdelkiMetadata dto = new izdelkiMetadata();
        dto.setId(entity.getId());
        dto.setIzdelekId(entity.getIzdelekId());
        dto.setNaziv(entity.getNaziv());

        return dto;

    }

    public static izdelkiMetadataEntity toEntity(izdelkiMetadata dto) {

        izdelkiMetadataEntity entity = new izdelkiMetadataEntity();
        entity.setCena(dto.getCena());
        entity.setNaziv(dto.getNaziv());
        entity.setId(dto.getId());
        entity.setIzdelekId(dto.getIzdelekId());

        return entity;

    }

}
