# Dagger 2 First Steps

Dagger is a dependency injection framework, handling all the boilerplate code you write by instantiating objects and passing them around as parameters.

## Setup

Go to the `build.gradle` file of your module and include the Dagger 2 dependencies.

```groovy
compile 'com.google.dagger:dagger:2.x'
annotationProcessor 'com.google.dagger:dagger-compiler:2.x'
```

Where the `x` is the number of the minor version. You can checkout the latest [here](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.google.dagger%22).

## Initial Code

I created the `NameGenerator` class which generates random names Strings in the format `<first name> <last name>`, and this class we can inject in the Main Activity with Dagger.

To use the powerfulness of the tool we need to do some work first.

## Define Module

We create a class called `AppModule` and here we define what and how the objects will be created. To achieve that we use the annotation `@Module` and `@Provides`.

The snipped below explains how we can code that:

```java
@Module
public class AppModule {

    @Provides
    public NameGenerator provideNameGenerator() {
        return new NameGenerator();
    }

}
```

With that done, our module is able to provides objects of `NameGenerator` wherever we annotate with `@Inject`. But to orquestrate all the pieces together we have more stuff to do.

## Define Component

Now it's time for defining the piece which will tell `Dagger` which modules or components provide de dependencies we want. So we create an interface called `AppComponent` and add the `AppModule` as one of its dependencies.

```java
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
```

This interface interface is responsible for telling `Dagger` how to generate the accessor classes to our objects, and also who can use them.a

## Use the Component

The get all the code Dagger generated up and running, we need to instantiate the components first, and then bind the activities we want to inject objects into.

For achieving this, we can create out component in the Application class.

```java
public class MyApplication extends Application {

    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerAppComponent.create();
    }

    public AppComponent getComponent() {
        return mComponent;
    }
}
```

Now when our application is created the component is as well, and to use it we can call `getApplication()` from any activity downcasting it to `MyApplication`.

The snipped below is put inside the `onCreate()` method in our `MainActivity` class.

```java
((MyApplication) getApplication())
        .getComponent()
        .inject(this);
```   

As soon as the Android executes the `inject()` method, it inject all the references we annotated with `@Inject`.

Check out the [repo](https://github.com/thyagostall/android-dagger) to more details on how all those pieces work together.

## Further Reading

Dagger is a really powerful tool, here I barely scratched the surface, there are many more concepts and tools to explore.

The links below provide this initial setup and much more:

[1] http://www.vogella.com/tutorials/Dagger/article.html
[2] https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2