package com.concrete.challenge.bean.categories.structure;

import com.concrete.challenge.bean.categories.mobile.behaviour.ConvertToMobile;

import java.io.Serializable;

public interface Category extends Serializable, Id, Name, Relevance, ConvertToMobile{
}
