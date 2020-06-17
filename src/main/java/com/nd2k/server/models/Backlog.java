package com.nd2k.server.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "backlog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer projectTaskSequence;
    private String projectIdentifier;

    public Date create_at = new Date();
    public Date update_at = new Date();

}
