package conykais.autodaggerdemo;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    Person person(){
        return new Person(123456,"hahaha");
    }

    @Provides
    @Singleton
    Mode mode(Person person){
        return new Mode("mode",person);
    }

}
