import * as lumi from "@lumi/lumi";
export declare class Preset extends lumi.NamedResource implements PresetArgs {
    readonly arn: string;
    readonly audio?: {
        audioPackingMode?: string;
        bitRate?: string;
        channels?: string;
        codec?: string;
        sampleRate?: string;
    }[];
    readonly audioCodecOptions?: {
        bitDepth?: string;
        bitOrder?: string;
        profile?: string;
        signed?: string;
    }[];
    readonly container: string;
    readonly description?: string;
    readonly presetName: string;
    readonly thumbnails?: {
        aspectRatio?: string;
        format?: string;
        interval?: string;
        maxHeight?: string;
        maxWidth?: string;
        paddingPolicy?: string;
        resolution?: string;
        sizingPolicy?: string;
    }[];
    readonly type: string;
    readonly video?: {
        aspectRatio?: string;
        bitRate?: string;
        codec?: string;
        displayAspectRatio?: string;
        fixedGop?: string;
        frameRate?: string;
        keyframesMaxDist?: string;
        maxFrameRate?: string;
        maxHeight?: string;
        maxWidth?: string;
        paddingPolicy?: string;
        resolution?: string;
        sizingPolicy?: string;
    }[];
    readonly videoCodecOptions?: {
        [key: string]: any;
    };
    readonly videoWatermarks?: {
        horizontalAlign?: string;
        horizontalOffset?: string;
        id?: string;
        maxHeight?: string;
        maxWidth?: string;
        opacity?: string;
        sizingPolicy?: string;
        target?: string;
        verticalAlign?: string;
        verticalOffset?: string;
    }[];
    constructor(name: string, args: PresetArgs);
}
export interface PresetArgs {
    readonly audio?: {
        audioPackingMode?: string;
        bitRate?: string;
        channels?: string;
        codec?: string;
        sampleRate?: string;
    }[];
    readonly audioCodecOptions?: {
        bitDepth?: string;
        bitOrder?: string;
        profile?: string;
        signed?: string;
    }[];
    readonly container: string;
    readonly description?: string;
    readonly presetName?: string;
    readonly thumbnails?: {
        aspectRatio?: string;
        format?: string;
        interval?: string;
        maxHeight?: string;
        maxWidth?: string;
        paddingPolicy?: string;
        resolution?: string;
        sizingPolicy?: string;
    }[];
    readonly type?: string;
    readonly video?: {
        aspectRatio?: string;
        bitRate?: string;
        codec?: string;
        displayAspectRatio?: string;
        fixedGop?: string;
        frameRate?: string;
        keyframesMaxDist?: string;
        maxFrameRate?: string;
        maxHeight?: string;
        maxWidth?: string;
        paddingPolicy?: string;
        resolution?: string;
        sizingPolicy?: string;
    }[];
    readonly videoCodecOptions?: {
        [key: string]: any;
    };
    readonly videoWatermarks?: {
        horizontalAlign?: string;
        horizontalOffset?: string;
        id?: string;
        maxHeight?: string;
        maxWidth?: string;
        opacity?: string;
        sizingPolicy?: string;
        target?: string;
        verticalAlign?: string;
        verticalOffset?: string;
    }[];
}

