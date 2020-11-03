/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.entities;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.concretesolutions.bffinitpage.ConstantsTest;
import com.google.gson.Gson;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest {
  @Test
  public void testParameters() {
    Category entity = getEntity();
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity);
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getIconImageUrl());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getId());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getName());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getRelevance());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getSmallImageUrl());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.getSubcategories());
    Assert.assertNotNull(ConstantsTest.MUST_BE_A_NOTNULL, entity.toString());
  }

  public static Category getEntity() {
    Category result = new Category();
    result.setId("123");
    result.setIconImageUrl("iconImageUrl");
    result.setName("name");
    result.setRelevance(1);
    result.setSmallImageUrl("smallImageUrl");
    result.getSubcategories();

    List<Category> list = new ArrayList<>();

    result.setSubcategories(list);
    return result;
  }

  public static Category getEntityResponse() {
    return new Gson().fromJson("{\n" + "  \"id\": \"ROOT\",\n" + "  \"name\": \"LEGACY_NAVIGATION\",\n"
        + "  \"subcategories\": [\n" + "    {\n" + "      \"id\": \"MOB\",\n" + "      \"name\": \"MOBILE_MARKET\",\n"
        + "      \"subcategories\": [\n" + "        {\n" + "          \"id\": \"video-games\",\n"
        + "          \"name\": \"Video Games\",\n" + "          \"relevance\": 150,\n"
        + "          \"subcategories\": [\n" + "            {\n" + "              \"id\": \"nintendo\",\n"
        + "              \"name\": \"Nintendo\",\n" + "              \"subcategories\": [\n" + "                {\n"
        + "                  \"id\": \"switch\",\n" + "                  \"name\": \"Switch\",\n"
        + "                  \"relevance\": 422\n" + "                }\n" + "              ],\n"
        + "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "            }\n" + "          ],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        },\n" + "        {\n" + "          \"id\": \"sports\",\n" + "          \"name\": \"Sports\",\n"
        + "          \"relevance\": 1,\n" + "          \"subcategories\": [\n" + "            {\n"
        + "              \"id\": \"bike\",\n" + "              \"name\": \"Bike\",\n"
        + "              \"relevance\": 350,\n" + "              \"subcategories\": [],\n"
        + "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "            }\n" + "          ],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        },\n" + "        {\n" + "          \"id\": \"electronics\",\n"
        + "          \"name\": \"Electronics\",\n" + "          \"subcategories\": [\n" + "            {\n"
        + "              \"id\": \"tv\",\n" + "              \"name\": \"TV\",\n"
        + "              \"subcategories\": [\n" + "                {\n" + "                  \"id\": \"4k\",\n"
        + "                  \"name\": \"4K\",\n" + "                  \"relevance\": 700\n" + "                }\n"
        + "              ],\n"
        + "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "            }\n" + "          ],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        },\n" + "        {\n" + "          \"id\": \"outdoor\",\n" + "          \"name\": \"Outdoor\",\n"
        + "          \"relevance\": 3,\n" + "          \"subcategories\": [],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        },\n" + "        {\n" + "          \"id\": \"food\",\n" + "          \"name\": \"Food\",\n"
        + "          \"relevance\": 4,\n" + "          \"subcategories\": [\n" + "            {\n"
        + "              \"id\": \"hamburger\",\n" + "              \"name\": \"Hamburger\",\n"
        + "              \"relevance\": 350,\n" + "              \"subcategories\": [],\n"
        + "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "            }\n" + "          ],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        },\n" + "        {\n" + "          \"id\": \"books\",\n" + "          \"name\": \"Books\",\n"
        + "          \"relevance\": 2,\n" + "          \"subcategories\": [],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        },\n" + "        {\n" + "          \"id\": \"travel\",\n" + "          \"name\": \"Travel\",\n"
        + "          \"relevance\": 5,\n" + "          \"subcategories\": [],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        },\n" + "        {\n" + "          \"id\": \"health\",\n" + "          \"name\": \"Health\",\n"
        + "          \"relevance\": 6,\n" + "          \"subcategories\": [],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        },\n" + "        {\n" + "          \"id\": \"toys\",\n" + "          \"name\": \"Toys\",\n"
        + "          \"relevance\": 99,\n" + "          \"subcategories\": [\n" + "            {\n"
        + "              \"id\": \"puzzles\",\n" + "              \"name\": \"Puzzles\",\n"
        + "              \"relevance\": 100,\n" + "              \"subcategories\": [],\n"
        + "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n"
        + "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "            }\n" + "          ],\n"
        + "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n"
        + "        }\n" + "      ]\n" + "    }\n" + "  ]\n" + "}\n" + "", Category.class);
  }

  public static List<Category> getList() {
    List<Category> list = new ArrayList<>();
    list.add(getEntity());
    return list;
  }
}
