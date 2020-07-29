package domain;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

public class Image implements Serializable {

    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = SEQUENCE,generator = "images_id_seq")
    @SequenceGenerator(name = "image_id_seq", sequenceName = "images_id_seq", allocationSize = 1)
    private long id;



}
