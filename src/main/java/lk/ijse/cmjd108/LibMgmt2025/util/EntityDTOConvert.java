package lk.ijse.cmjd108.LibMgmt2025.util;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDTOConvert {
    private final ModelMapper modelMapper;

    //Book
    public BookEntity convertBookDTOToBookEntity(BookDTO bookDTO){
        return modelMapper.map(bookDTO, BookEntity.class);
    }
    public BookDTO convertBookEntityToBookDTO(BookEntity bookEntity){
        return modelMapper.map(bookEntity, BookDTO.class);
    }
    public List<BookDTO> toBookDTOList(List<BookEntity> bookEntities){
        return modelMapper.map(bookEntities,new TypeToken<List<BookDTO>>(){}.getType());
    }
}
