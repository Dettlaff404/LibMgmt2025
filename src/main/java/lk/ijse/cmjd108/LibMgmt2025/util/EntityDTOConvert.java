package lk.ijse.cmjd108.LibMgmt2025.util;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
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

    //Member
    public MemberEntity convertMemberDTOToMemberEntity(MemberDTO memberDTO){
        return modelMapper.map(memberDTO, MemberEntity.class);
    }
    public MemberDTO convertMemberEntityToMemberDTO(MemberEntity memberEntity){
        return modelMapper.map(memberEntity, MemberDTO.class);
    }
    public List<MemberDTO> toMemberDTOList(List<MemberEntity> memberEntities){
        return modelMapper.map(memberEntities,new TypeToken<List<MemberDTO>>(){}.getType());
    }
}
