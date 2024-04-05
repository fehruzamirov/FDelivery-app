package com.deliverybusiness.model.view;

public class View {

    public static class ShowName{}
    public static class ShowAddress extends ShowName{}

    public static class ShowZipCode extends ShowName{}
    public static class ShowAll extends ShowZipCode{}

    public static class ShowStatus extends ShowName{}

    public static class Minimal{}
    public static class Master extends Minimal{}
}
