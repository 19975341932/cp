package com.cp.sb.base.mapstruct;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonMapperImpl implements IPersonMapper{

         public PersonMapperImpl() {

        }

        public PersonDTO conver(PersonVo person) {
            if (person == null) {
                return null;

            } else {

                PersonDTO personDTO = new PersonDTO();
                if(person.getDescrib() != null){
                    personDTO.setDescribe(person.getDescrib());
                }else{
                    personDTO.setDescribe("eason我的爱");
                }

                if (person.getId() != null) {
                    personDTO.setId(Long.parseLong(person.getId()));
                }

                personDTO.setPersonName(person.getName());
                personDTO.setAge(String.valueOf(person.getAge()));
                if (person.getSource() != null) {
                    personDTO.setSource(person.getSource().toString());
                }
                try {
                    if (person.getCreateTime() != null) {
                        try {
                            personDTO.setCreateTime((new SimpleDateFormat("yyyy-MM-dd")).parse(person.getCreateTime()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }  catch (Exception e) {
                e.printStackTrace();
            }



                personDTO.setHeight(String.valueOf(person.getHeight()));
                return personDTO;
            }
        }
    }
