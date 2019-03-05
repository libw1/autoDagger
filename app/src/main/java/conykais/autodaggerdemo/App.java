package conykais.autodaggerdemo;

import android.app.Application;
import android.text.TextUtils;

import javax.inject.Singleton;

import autodagger.AutoComponent;
import autodagger.AutoInjector;

@Singleton
@AutoComponent(
        modules = {AppModule.class, TestModule.class},
        superinterfaces = AppDependencies.class
)
@AutoInjector(App.class)
public class App extends Application{

    private AppComponent appComponent;

    @Override
    public Object getSystemService(String name) {
        if (TextUtils.equals(name,DaggerService.SERVICE_NAME)){
            return appComponent;
        }
        return super.getSystemService(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = onCreateComponent();
        appComponent.inject(this);
    }

    private AppComponent onCreateComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .testModule(new TestModule())
//                .modeModlue(new ModeModlue())
                .build();
    }

}
