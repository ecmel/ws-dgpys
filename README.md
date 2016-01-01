# ws-dgpys
EPIAS (PMUM) Axis2 Web Service Client

## Example Usage

```
EVDServisStub stub = EVDServisStubFactory.newInstance();

LoginDocument ld = LoginDocument.Factory.newInstance();
ld.addNewLogin().addNewLoginMessage();
ld.getLogin().getLoginMessage().addNewUserName().setV("username");
ld.getLogin().getLoginMessage().addNewPassword().setV("password");
stub.login(ld);

Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);

GetGunOncesiFiyatDocument gop = GetGunOncesiFiyatDocument.Factory.newInstance();
gop.addNewGetGunOncesiFiyat().setDate(cal);
stub.getGunOncesiFiyat(gop);

stub.cleanup();
```
