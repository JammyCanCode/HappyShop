package ci553.happyshop.clientLogin;


import ci553.happyshop.client.customer.CustomerController;
import ci553.happyshop.client.customer.CustomerModel;
import ci553.happyshop.client.customer.CustomerView;
import ci553.happyshop.client.customer.RemoveProductNotifier;
import ci553.happyshop.storageAccess.DatabaseRW;
import ci553.happyshop.storageAccess.DatabaseRWCreator;
import javafx.stage.Stage;

public class CustomerLoginModel extends LoginModel {

    @Override
    protected void onLoginSuccess(){
        logView.close();

        DatabaseRW databaseRW = DatabaseRWCreator.createDatabaseRW();

        CustomerView cusView = new CustomerView();
        CustomerController cusController = new CustomerController();
        CustomerModel cusModel = new CustomerModel(databaseRW);

        cusView.cusController = cusController;
        cusController.cusModel = cusModel;
        cusModel.cusView = cusView;
        cusView.start(new Stage());

        RemoveProductNotifier removeProductNotifier = new RemoveProductNotifier();
        removeProductNotifier.cusView = cusView;
        cusModel.removeProductNotifier = removeProductNotifier;
    }
}
