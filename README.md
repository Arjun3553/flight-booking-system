# Prerequisites

Install the following applications in your local machine

## Visual Studio Code

```
https://code.visualstudio.com/docs/?dv=win64
```

## Vault Zip File

```
https://developer.hashicorp.com/vault/install
```

## Extensions For VSCode

```
vscjava.vscode-java-pack
VisualStudioExptTeam.vscodeintellicode
vmware.vscode-boot-dev-pack
```

## MySQL

```
https://dev.mysql.com/downloads/mysql/
```

# Let's Begin

## Clone the Repository

```
git clone https://github.com/Arjun3553/flight-booking-system.git
```

open the repo in your vscode.

## Add Extensions to VSCode

copy the extension from [Extension For VSCode](##-Extensions-For-VSCode) and paste it into your vscode code extension search bar and add them.

## Vault Configuration

Extract the zip file and add it any directory of your choice

Example:

![vault zip img](https://github.com/Arjun3553/flight-booking-system.git/Images/vaultzip.png)

![vault folder img](https://github.com/Arjun3553/flight-booking-system.git/Images/vaultunzip.png)

copy the path of the vault folder and add the path into system enviroment variables.

### run the following command to start the vault server locally

open new cmd / terminal / powershell and type the following command.

```
vault --version
```

to check if vault is configured properly

```
vault server -dev
```

to start the vault server in development mode

once the server is started, open new cmd / terminal / powershell and execute the following command

```
set VAULT_ADDR=http://127.0.0.1:8200
```

```
vault kv put secret/configserver spring.datasource.username={give your database username} spring.datasource.password={give your database password}
```

to create data inside the vault kv secret engine

```
vault kv get secret/configserver
```

to view the data inside the vault kv secret engine, which we create now.

Also, you can find a root token generated for you whenever you restart the vault server, copy the token and paste it in the application.properties file of the configserver folder each time when you run the vault server and don't forget to uncomment [ # spring.cloud.config.server.vault.token="give-your-root-token" ].
