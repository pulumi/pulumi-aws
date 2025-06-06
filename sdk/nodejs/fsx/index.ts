// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

// Export members:
export { BackupArgs, BackupState } from "./backup";
export type Backup = import("./backup").Backup;
export const Backup: typeof import("./backup").Backup = null as any;
utilities.lazyLoad(exports, ["Backup"], () => require("./backup"));

export { DataRepositoryAssociationArgs, DataRepositoryAssociationState } from "./dataRepositoryAssociation";
export type DataRepositoryAssociation = import("./dataRepositoryAssociation").DataRepositoryAssociation;
export const DataRepositoryAssociation: typeof import("./dataRepositoryAssociation").DataRepositoryAssociation = null as any;
utilities.lazyLoad(exports, ["DataRepositoryAssociation"], () => require("./dataRepositoryAssociation"));

export { FileCacheArgs, FileCacheState } from "./fileCache";
export type FileCache = import("./fileCache").FileCache;
export const FileCache: typeof import("./fileCache").FileCache = null as any;
utilities.lazyLoad(exports, ["FileCache"], () => require("./fileCache"));

export { GetOntapFileSystemArgs, GetOntapFileSystemResult, GetOntapFileSystemOutputArgs } from "./getOntapFileSystem";
export const getOntapFileSystem: typeof import("./getOntapFileSystem").getOntapFileSystem = null as any;
export const getOntapFileSystemOutput: typeof import("./getOntapFileSystem").getOntapFileSystemOutput = null as any;
utilities.lazyLoad(exports, ["getOntapFileSystem","getOntapFileSystemOutput"], () => require("./getOntapFileSystem"));

export { GetOntapStorageVirtualMachineArgs, GetOntapStorageVirtualMachineResult, GetOntapStorageVirtualMachineOutputArgs } from "./getOntapStorageVirtualMachine";
export const getOntapStorageVirtualMachine: typeof import("./getOntapStorageVirtualMachine").getOntapStorageVirtualMachine = null as any;
export const getOntapStorageVirtualMachineOutput: typeof import("./getOntapStorageVirtualMachine").getOntapStorageVirtualMachineOutput = null as any;
utilities.lazyLoad(exports, ["getOntapStorageVirtualMachine","getOntapStorageVirtualMachineOutput"], () => require("./getOntapStorageVirtualMachine"));

export { GetOntapStorageVirtualMachinesArgs, GetOntapStorageVirtualMachinesResult, GetOntapStorageVirtualMachinesOutputArgs } from "./getOntapStorageVirtualMachines";
export const getOntapStorageVirtualMachines: typeof import("./getOntapStorageVirtualMachines").getOntapStorageVirtualMachines = null as any;
export const getOntapStorageVirtualMachinesOutput: typeof import("./getOntapStorageVirtualMachines").getOntapStorageVirtualMachinesOutput = null as any;
utilities.lazyLoad(exports, ["getOntapStorageVirtualMachines","getOntapStorageVirtualMachinesOutput"], () => require("./getOntapStorageVirtualMachines"));

export { GetOpenZfsSnapshotArgs, GetOpenZfsSnapshotResult, GetOpenZfsSnapshotOutputArgs } from "./getOpenZfsSnapshot";
export const getOpenZfsSnapshot: typeof import("./getOpenZfsSnapshot").getOpenZfsSnapshot = null as any;
export const getOpenZfsSnapshotOutput: typeof import("./getOpenZfsSnapshot").getOpenZfsSnapshotOutput = null as any;
utilities.lazyLoad(exports, ["getOpenZfsSnapshot","getOpenZfsSnapshotOutput"], () => require("./getOpenZfsSnapshot"));

export { GetWindowsFileSystemArgs, GetWindowsFileSystemResult, GetWindowsFileSystemOutputArgs } from "./getWindowsFileSystem";
export const getWindowsFileSystem: typeof import("./getWindowsFileSystem").getWindowsFileSystem = null as any;
export const getWindowsFileSystemOutput: typeof import("./getWindowsFileSystem").getWindowsFileSystemOutput = null as any;
utilities.lazyLoad(exports, ["getWindowsFileSystem","getWindowsFileSystemOutput"], () => require("./getWindowsFileSystem"));

export { LustreFileSystemArgs, LustreFileSystemState } from "./lustreFileSystem";
export type LustreFileSystem = import("./lustreFileSystem").LustreFileSystem;
export const LustreFileSystem: typeof import("./lustreFileSystem").LustreFileSystem = null as any;
utilities.lazyLoad(exports, ["LustreFileSystem"], () => require("./lustreFileSystem"));

export { OntapFileSystemArgs, OntapFileSystemState } from "./ontapFileSystem";
export type OntapFileSystem = import("./ontapFileSystem").OntapFileSystem;
export const OntapFileSystem: typeof import("./ontapFileSystem").OntapFileSystem = null as any;
utilities.lazyLoad(exports, ["OntapFileSystem"], () => require("./ontapFileSystem"));

export { OntapStorageVirtualMachineArgs, OntapStorageVirtualMachineState } from "./ontapStorageVirtualMachine";
export type OntapStorageVirtualMachine = import("./ontapStorageVirtualMachine").OntapStorageVirtualMachine;
export const OntapStorageVirtualMachine: typeof import("./ontapStorageVirtualMachine").OntapStorageVirtualMachine = null as any;
utilities.lazyLoad(exports, ["OntapStorageVirtualMachine"], () => require("./ontapStorageVirtualMachine"));

export { OntapVolumeArgs, OntapVolumeState } from "./ontapVolume";
export type OntapVolume = import("./ontapVolume").OntapVolume;
export const OntapVolume: typeof import("./ontapVolume").OntapVolume = null as any;
utilities.lazyLoad(exports, ["OntapVolume"], () => require("./ontapVolume"));

export { OpenZfsFileSystemArgs, OpenZfsFileSystemState } from "./openZfsFileSystem";
export type OpenZfsFileSystem = import("./openZfsFileSystem").OpenZfsFileSystem;
export const OpenZfsFileSystem: typeof import("./openZfsFileSystem").OpenZfsFileSystem = null as any;
utilities.lazyLoad(exports, ["OpenZfsFileSystem"], () => require("./openZfsFileSystem"));

export { OpenZfsSnapshotArgs, OpenZfsSnapshotState } from "./openZfsSnapshot";
export type OpenZfsSnapshot = import("./openZfsSnapshot").OpenZfsSnapshot;
export const OpenZfsSnapshot: typeof import("./openZfsSnapshot").OpenZfsSnapshot = null as any;
utilities.lazyLoad(exports, ["OpenZfsSnapshot"], () => require("./openZfsSnapshot"));

export { OpenZfsVolumeArgs, OpenZfsVolumeState } from "./openZfsVolume";
export type OpenZfsVolume = import("./openZfsVolume").OpenZfsVolume;
export const OpenZfsVolume: typeof import("./openZfsVolume").OpenZfsVolume = null as any;
utilities.lazyLoad(exports, ["OpenZfsVolume"], () => require("./openZfsVolume"));

export { WindowsFileSystemArgs, WindowsFileSystemState } from "./windowsFileSystem";
export type WindowsFileSystem = import("./windowsFileSystem").WindowsFileSystem;
export const WindowsFileSystem: typeof import("./windowsFileSystem").WindowsFileSystem = null as any;
utilities.lazyLoad(exports, ["WindowsFileSystem"], () => require("./windowsFileSystem"));


const _module = {
    version: utilities.getVersion(),
    construct: (name: string, type: string, urn: string): pulumi.Resource => {
        switch (type) {
            case "aws:fsx/backup:Backup":
                return new Backup(name, <any>undefined, { urn })
            case "aws:fsx/dataRepositoryAssociation:DataRepositoryAssociation":
                return new DataRepositoryAssociation(name, <any>undefined, { urn })
            case "aws:fsx/fileCache:FileCache":
                return new FileCache(name, <any>undefined, { urn })
            case "aws:fsx/lustreFileSystem:LustreFileSystem":
                return new LustreFileSystem(name, <any>undefined, { urn })
            case "aws:fsx/ontapFileSystem:OntapFileSystem":
                return new OntapFileSystem(name, <any>undefined, { urn })
            case "aws:fsx/ontapStorageVirtualMachine:OntapStorageVirtualMachine":
                return new OntapStorageVirtualMachine(name, <any>undefined, { urn })
            case "aws:fsx/ontapVolume:OntapVolume":
                return new OntapVolume(name, <any>undefined, { urn })
            case "aws:fsx/openZfsFileSystem:OpenZfsFileSystem":
                return new OpenZfsFileSystem(name, <any>undefined, { urn })
            case "aws:fsx/openZfsSnapshot:OpenZfsSnapshot":
                return new OpenZfsSnapshot(name, <any>undefined, { urn })
            case "aws:fsx/openZfsVolume:OpenZfsVolume":
                return new OpenZfsVolume(name, <any>undefined, { urn })
            case "aws:fsx/windowsFileSystem:WindowsFileSystem":
                return new WindowsFileSystem(name, <any>undefined, { urn })
            default:
                throw new Error(`unknown resource type ${type}`);
        }
    },
};
pulumi.runtime.registerResourceModule("aws", "fsx/backup", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/dataRepositoryAssociation", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/fileCache", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/lustreFileSystem", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/ontapFileSystem", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/ontapStorageVirtualMachine", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/ontapVolume", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/openZfsFileSystem", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/openZfsSnapshot", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/openZfsVolume", _module)
pulumi.runtime.registerResourceModule("aws", "fsx/windowsFileSystem", _module)
