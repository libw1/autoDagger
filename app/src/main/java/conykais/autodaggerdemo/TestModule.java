package conykais.autodaggerdemo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    TestModule(){

    }

    @Provides
    @Singleton
    Test test(){
        return new Test("test");
    }
}
