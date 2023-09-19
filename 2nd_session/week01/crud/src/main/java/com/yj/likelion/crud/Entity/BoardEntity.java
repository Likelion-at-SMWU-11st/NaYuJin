package com.yj.likelion.crud.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="table")
@Getter
@Setter
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch=FetchType.LAZY,
            mappedBy = "boardEntity"
    )

    private List<PostEntity> postEntityList=new ArrayList<>();
}
