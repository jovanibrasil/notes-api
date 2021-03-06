package com.notes.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.notes.controller.dto.NotebookDTO;
import com.notes.model.Notebook;

@Mapper
@DecoratedWith(NotebookMapperDecorator.class)
public interface NotebookMapper {
    @Mapping(target = "title", source = "name")
    Notebook notebookDtoToNotebook(NotebookDTO notebookDTO);
    @Mapping(target = "name", source = "title")
    NotebookDTO notebookToNotebookDto(Notebook notebook);
}
